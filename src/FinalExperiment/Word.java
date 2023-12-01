package FinalExperiment;

public class Word {
    String english;
    String chinese;
    int frequency;

    public Word() {
    }

    public Word(String english, String chinese) {
        this.english = english;
        this.chinese = chinese;
        this.frequency = 0;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
