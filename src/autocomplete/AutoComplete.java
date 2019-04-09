package autocomplete;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class AutoComplete implements DocumentListener {

  private static enum Mode {
    INSERT,
    COMPLETION
  };

  private JTextField textField;
  private static List<String> keywords;
  private Mode mode = Mode.INSERT;

  public AutoComplete(JTextField textField, List<String> keywords) {
    this.textField = textField;
    this.keywords = keywords;
    Collections.sort(keywords);
  }

  @Override
  public void changedUpdate(DocumentEvent ev) { }

  @Override
  public void removeUpdate(DocumentEvent ev) { }

  @Override
  public void insertUpdate(DocumentEvent ev) {
    if (ev.getLength() != 1)
      return;

    int pos = ev.getOffset();
    String content = null;
    try {
      content = textField.getText(0, pos + 1);
    } catch (BadLocationException e) {
      e.printStackTrace();
    }

    // Find where the word starts
    int w;
    for (w = pos; w >= 0; w--) {
      if (!Character.isLetter(content.charAt(w))) {
        break;
      }
    }

    // Too few chars
    if (pos - w < 2)
      return;

    String prefix = content.substring(w + 1).toLowerCase();
    int n = Collections.binarySearch(keywords, prefix);
    if (n < 0 && -n <= keywords.size()) {
      String match = keywords.get(-n - 1);
      if (match.startsWith(prefix)) {
        // A completion is found
        String completion = match.substring(pos - w);
        // We cannot modify Document from within notification,
        // so we submit a task that does the change later
        SwingUtilities.invokeLater(new CompletionTask(completion, pos + 1));
      }
    } else {
      // Nothing found
      mode = Mode.INSERT;
    }
  }

  public class CommitAction extends AbstractAction {
    /**
     * 
     */
    private static final long serialVersionUID = 5794543109646743416L;

    @Override
    public void actionPerformed(ActionEvent ev) {
      if (mode == Mode.COMPLETION) {
        int pos = textField.getSelectionEnd();
        StringBuffer sb = new StringBuffer(textField.getText());
        sb.insert(pos, " ");
        textField.setText(sb.toString());
        textField.setCaretPosition(pos + 1);
        mode = Mode.INSERT;
      } else {
        textField.replaceSelection("\t");
      }
    }
  }

  private class CompletionTask implements Runnable {
    private String completion;
    private int position;

    CompletionTask(String completion, int position) {
      this.completion = completion;
      this.position = position;
    }

    public void run() {
      StringBuffer sb = new StringBuffer(textField.getText());
      sb.insert(position, completion);
      textField.setText(sb.toString());
      textField.setCaretPosition(position + completion.length());
      textField.moveCaretPosition(position);
      mode = Mode.COMPLETION;
    }
  }
  public static void main(String[] args) {
	  final String COMMIT_ACTION = "commit";
	  JTextField mainTextField = new JTextField();

	  // Without this, cursor always leaves text field
	  mainTextField.setFocusTraversalKeysEnabled(false);
	  
	  // Our words to complete
	  keywords = new ArrayList<String>(5);
	          keywords.add("example");
	          keywords.add("autocomplete");
	          keywords.add("stackabuse");
	          keywords.add("java");
	  AutoComplete autoComplete = new AutoComplete(mainTextField, keywords);
	  mainTextField.getDocument().addDocumentListener(autoComplete);

	  // Maps the tab key to the commit action, which finishes the autocomplete
	  // when given a suggestion
	  mainTextField.getInputMap().put(KeyStroke.getKeyStroke("TAB"), COMMIT_ACTION);
	  mainTextField.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
	  JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 0, 1200, 735);
		frame.setVisible(true);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 1184, 696);
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		mainTextField.setBounds(10,10,200,20);
		contentPane.add(mainTextField);
  }
}