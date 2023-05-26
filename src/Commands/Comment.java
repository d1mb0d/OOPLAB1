package Commands;

public class Comment extends Command {
    private String comment;

    public Comment(String comment) {
        this.comment = comment;
    }

    @Override
    public void execute(CalcContext context) throws CalcException {
        // Do nothing, as comments don't affect the calculator's stack
    }

    public static boolean isComment(String line) {
        return line.trim().startsWith("#");
    }

    public static Comment createComment(String line) {
        String comment = line.trim().substring(1).trim();
        return new Comment(comment);
    }
}
