package csu.csci325;




import java.time.Instant;
import java.util.Date;
import java.util.Iterator;


/**
 *
 * @author iango
 */
public class QtimeNote implements Comparable<QtimeNote>{
	private Date date;
	private String book;
	private String verse;
	private String note;

	public QtimeNote(String book, String verse, String note) {
		this.date = date;
		this.book = book;
		this.verse = verse;
		this.note = note;
		
		date = Date.from(Instant.now());
	}

	
	@Override
	public int compareTo(QtimeNote n){
		int retVal;

		retVal = book.compareTo(n.getBookOfBible());
		if(0 == retVal) {
			retVal = verse.compareTo(n.getVerseRef());
		}

		if(retVal > 0){
			retVal = -retVal;
		}
		return retVal;
	}

	public String getBookOfBible() {
		return book;
	}
	public Date getDate() {
		return date;
	}
	public String getUserNotes() {
		return note;
	}
	public String getVerseRef() {
		return verse;
	}
	public void updateUserNotes(String userNotes){
		note += userNotes;
	}

	@Override
	public String toString() {
		return "Book: " + book + 
				", Verse: " + verse + 
				", Notes: " + note +
				"\n";
	}

//	public static void main(String[] args) {
//		QtimeNote note = new QtimeNote("Jeremiah", "29:11",	"One of my Favs.");
//
//		System.out.println("Date: " + note.getDate().toString());
//
//		System.out.println("Book: " + note.getBookOfBible());
//		System.out.println("Verse: " + note.getVerseRef());
//		System.out.println("Notes: " + note.getUserNotes());
//
//		// updating notes
//		note.updateUserNotes("This is a test note.");
//
//		System.out.println("Notes: " +note.getUserNotes());
//		
//		QtimeNote note2 = new QtimeNote("Jeremiah", "27:1", "One of my Favs.");
//		System.out.println(note.compareTo(note2));
//	}

}
