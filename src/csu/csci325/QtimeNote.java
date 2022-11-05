package csu.csci325;




import java.time.Instant;
import java.util.Date;


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
		int retVal, chapter, chapter1, v, v1;
		String tmp;
		String[] verseRef, verseRef1;

		retVal = book.compareTo(n.getBookOfBible());
		if(0 == retVal) {
			// extract chapter and verse then compare them as integers
			verse.trim();
			tmp = n.getVerseRef();
			tmp.trim();
			verseRef = verse.split(":");
			verseRef1 = tmp.split(":");
			
			// if chapter is the same
			retVal = Integer.parseInt(verseRef[0]) - Integer.parseInt(verseRef1[0]);
			if (0 == retVal)
			{
				// compare the verse
				retVal = Integer.parseInt(verseRef[1]) - Integer.parseInt(verseRef1[1]);
			}
			
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
//
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
