import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class DigitFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (isValidInput(fb, string)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (isValidInput(fb, text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean isValidInput(FilterBypass fb, String text) {
        if (text.matches("\\d")) {
            int newLength = fb.getDocument().getLength() + text.length();
            return newLength <= 1;
        }
        return false;
    }
}