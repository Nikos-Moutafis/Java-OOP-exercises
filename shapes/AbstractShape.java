package gr.aueb.cf.ch16.exercise2;

public class AbstractShape implements IShape {
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
