package spr.beans;

public class Sports {

    private int sportId;
    private String sportName;
    private String about;
    
    @Override
    public String toString(){
        return sportName+"  "+about;
    }
    
    public Sports(){}
    public Sports(int sportId, String sportName, String about) {
        this.sportId = sportId;
        this.sportName = sportName;
        this.about = about;
    }

    /**
     * @return the sportName
     */
    public String getSportName() {
        return sportName;
    }

    /**
     * @param sportName the sportName to set
     */
    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    /**
     * @return the about
     */
    public String getAbout() {
        return about;
    }

    /**
     * @param about the about to set
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * @return the sportId
     */
    public int getSportId() {
        return sportId;
    }

    /**
     * @param sportId the sportId to set
     */
    public void setSportId(int sportId) {
        this.sportId = sportId;
    }
}
