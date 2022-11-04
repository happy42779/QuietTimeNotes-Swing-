package csu.csci325;


import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * @author iango
 */
public class Qtime {

	private List<QtimeNote> noteList;
	private int qNoteListSize;

	public Qtime() {
		noteList = new LinkedList<QtimeNote>();
		qNoteListSize = 0;
	}

	public List<QtimeNote> getNoteList() {
		return noteList;
	}

	public int getNoteListSize() {
		return qNoteListSize;
	}

	// removes all notes for a specified book
	public void removeNotes(String book) {
		Iterator<QtimeNote> it = noteList.iterator();

		while (it.hasNext()) {
			QtimeNote n = (QtimeNote) it.next();
			if (0 == n.getBookOfBible().compareTo(book)) {
				it.remove();
				--qNoteListSize;
			}
		}
	}

	// add the given note to the end if the note is does not exit,
	// otherwise update
	public void setNote(QtimeNote qtimeNote) {
		boolean bNoteExists = false;
		Iterator<QtimeNote> it = noteList.iterator();

		// if the book and verse is present in the list, then update notes
		while (it.hasNext() && !bNoteExists) {
			QtimeNote n = (QtimeNote) it.next();
			if (0 == n.compareTo(qtimeNote)) {
				n.updateUserNotes(qtimeNote.getUserNotes());
				bNoteExists = true;
			}
		}
		if (!bNoteExists) {
			noteList.add(qtimeNote);
			++qNoteListSize;
		}
	}

	public void sortNotes() {
		Collections.sort(noteList);
	}

	public void updateUserNote(QtimeNote qtimeNote, String userNotes) {
		Iterator<QtimeNote> it = noteList.iterator();

		while (it.hasNext()) {
			QtimeNote n = (QtimeNote) it.next();
			if (0 == n.compareTo(qtimeNote)) {
				n.updateUserNotes(userNotes);
			}
		}
	}

	@Override
	public String toString() {
		String str = "";
		Iterator<QtimeNote> it = noteList.iterator();

		while (it.hasNext()) {
			QtimeNote n = (QtimeNote)it.next();
			str += n.toString();
		}
		return str;
	}

//	public static void main(String[] args) {
//		Qtime qtime = new Qtime();
//
//		System.out.println("Size: " + qtime.getNoteListSize());
//
//		// add 
//		qtime.setNote(new QtimeNote("John", "3:16", "Love"));
//		System.out.println("Qtime: " + qtime);
//		// set the same book and verse
//		qtime.setNote(new QtimeNote("John", "3:16", "God's love is great!"));
//		System.out.println("Qtime: " + qtime);
//		System.out.println("Size: " + qtime.getNoteListSize());
//
//		// add another one
//		qtime.setNote(new QtimeNote("Genesis", "1:1-8", "God created everthing."));
//		System.out.println("Qtime: " + qtime);
//		System.out.println("Size: " + qtime.getNoteListSize());
//
//		// update notes
//		QtimeNote note = new QtimeNote("Psalm", "23:1", "Lord is my sheperd.");
//		qtime.setNote(note);
//		qtime.updateUserNote(note, "I shall not be in want!");
//		System.out.println("Qtime: " + qtime);
//		System.out.println("Size: " + qtime.getNoteListSize());
//
//	}

}
