package csu.csci325;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author iango
 */
public class QtimeUI extends JFrame implements ActionListener {
	public void initComponents(){
		GridBagConstraints layoutConst = null;
		
		super.setTitle("Quiet Time Notes");
		
		labelBook = new JLabel("Book of Bible: ");
		labelNotes = new JLabel("Notes: ");
		labelVerse = new JLabel("Chapter & verse: ");

		inputBook = new JTextField(30);
		inputBook.setEditable(true);

		inputVerse = new JTextField(30);
		inputVerse.setEditable(true);

		inputNotes = new JTextField(30);
		inputNotes.setEditable(true);

		btnAddUpdate = new JButton("Add/Update Note");
		btnRemoveAll = new JButton("Remove Notes");
		btnSort = new JButton("Sort Notes");
		btnPrint = new JButton("Print Notes");

		btnRemoveAll.addActionListener(this);
		btnAddUpdate.addActionListener(this);
		btnSort.addActionListener(this);
		btnPrint.addActionListener(this);

		areaNotes = new JTextArea();
		scrollPane = new JScrollPane(areaNotes);
		areaNotes.setEditable(false);
		
		
		// add all the controls to the main frame
		// add from top left corner
		super.setLayout(new GridBagLayout());
		layoutConst = new GridBagConstraints();
		layoutConst.anchor = GridBagConstraints.LINE_END;
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		super.add(labelBook, layoutConst);

		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		layoutConst.gridwidth = 3;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		super.add(inputBook, layoutConst);

		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.gridwidth = 1;
		layoutConst.anchor = GridBagConstraints.LINE_END;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		super.add(labelVerse, layoutConst);

		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		layoutConst.gridwidth = 3;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		super.add(inputVerse, layoutConst);


		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		layoutConst.gridwidth = 1;
		layoutConst.anchor = GridBagConstraints.LINE_END;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		super.add(labelNotes, layoutConst);

		layoutConst.gridx = 1;
		layoutConst.gridy = 2;
		layoutConst.gridwidth = 3;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		super.add(inputNotes, layoutConst);

		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		layoutConst.gridwidth = 1;
		layoutConst.insets = new Insets(20, 10, 20, 10);
		super.add(btnAddUpdate, layoutConst);

		layoutConst.gridx = 1;
		layoutConst.gridy = 3;
		layoutConst.gridwidth = 1;
		layoutConst.insets = new Insets(20, 10, 20, 10);
		super.add(btnRemoveAll, layoutConst);

		layoutConst.gridx = 2;
		layoutConst.gridy = 3;
		layoutConst.gridwidth = 1;
		layoutConst.insets = new Insets(20, 10, 20, 10);
		super.add(btnSort, layoutConst);
		
		layoutConst.gridx = 3;
		layoutConst.gridy = 3;
		layoutConst.gridwidth = 1;
		layoutConst.insets = new Insets(20, 10, 20, 10);
		super.add(btnPrint, layoutConst);

		layoutConst.gridx = 0;
		layoutConst.gridy = 4;
		layoutConst.fill= GridBagConstraints.HORIZONTAL;
		layoutConst.gridwidth = 4;
		layoutConst.ipady = 150;
		layoutConst.insets = new Insets(20, 10, 20, 10);
		super.add(scrollPane, layoutConst);
	}

	public QtimeUI() {
		initComponents();
		// instantiate Qtime object
		qtime = new Qtime();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton srcEvent = (JButton) e.getSource();

		if(srcEvent == btnAddUpdate){
			onBtnAddUpdate();
		}
		else if(srcEvent == btnRemoveAll){
			onBtnRemove();
		}
		else if(srcEvent == btnSort){
			onBtnSort();
		}
		else if(srcEvent == btnPrint){
			onBtnPrint();
		}
	}


	/**
	 * Button actions handle functions
	 */
	public void onBtnAddUpdate(){
		String book = inputBook.getText();
		String verse = inputVerse.getText();
		String note = inputNotes.getText();
		QtimeNote n = new QtimeNote(book, verse, note);

		qtime.setNote(n);

		areaNotes.append("1 note added/updated: \n");
		areaNotes.append(n.toString());
	}
	public void onBtnRemove(){
		String book = inputBook.getText();
		if(book.isEmpty()){
			JOptionPane.showMessageDialog(this, "Please specify the book name!");
			return;
		}
		
		qtime.removeNotes(book);
		
		areaNotes.append("All notes of " + book + "has been removed.\n");
	}
	public void onBtnSort(){
		qtime.sortNotes();

		areaNotes.append("Notes Sorted incrementally.\n");
	}

	private void onBtnPrint() {
		areaNotes.append("Qtime Notes: \n");
		areaNotes.append(qtime.toString());
	}

	private Qtime qtime;

	private JLabel labelBook;
	private JLabel labelVerse;
	private JLabel labelNotes;
	private JTextField inputBook;
	private JTextField inputVerse;
	private JTextField inputNotes;
	private JButton btnAddUpdate;
	private JButton btnRemoveAll;
	private JButton btnSort;
	private JButton btnPrint;
	private JTextArea areaNotes;
	private JScrollPane scrollPane;

	public static void main(String[] args) {
		QtimeUI myQtime = new QtimeUI();
		
		myQtime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myQtime.pack();
		myQtime.setVisible(true);
		
	}

	
}
