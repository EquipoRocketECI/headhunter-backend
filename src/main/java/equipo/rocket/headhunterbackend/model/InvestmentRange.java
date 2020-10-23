package equipo.rocket.headhunterbackend.model;

public class InvestmentRange {

    private int lowBound;
    private int highBound;

    public InvestmentRange(int lowBound, int highBound) {
        this.lowBound = lowBound;
        this.highBound = highBound;
    }

    public boolean isInRange(int investment) {
        return lowBound<=investment && highBound>=investment;
    }

    public int getLowBound() {
        return lowBound;
    }

    public void setLowBound(int lowBound) {
        this.lowBound = lowBound;
    }

    public int getHighBound() {
        return highBound;
    }

    public void setHighBound(int highBound) {
        this.highBound = highBound;
    }
    
}
