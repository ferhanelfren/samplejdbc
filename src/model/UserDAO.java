package model;




public class UserDAO {
    
    private String FName;
    private String MName;
    private String LName;
    private int Age;
    private String Address;
    private String Gender;
    private String CivilStatus;
    
//    public UserDAO(String FName, String MName, String LName, int Age) {
//      this.FName = FName;
//      this.MName = MName;
//      this.LName = LName;
//      this.Age = Age;
//    }
    public String getFName() {
        return FName;
    }
    public void setFName(String FName) {
        this.FName = FName;
    }
    
    
    public String getMName() {
        return MName;
    }
    public void setMName(String MName) {
        this.MName = MName;
    }
    
    
    public String getLName() {
        return LName;
    }
    public void setLName(String LName) {
        this.LName = LName;
    }
    
    
    public int getAge() {
        return Age;
    }
    public void setAge(int Age) {
        this.Age = Age;
    }
    
    public String getAddress(){
        return Address;
    }
    
    public void setAddress(String Address){
        this.Address = Address;
    }
    
    
    public String getGender(){
        return Gender;
    }
    
    public void setGender(String Gender){
        this.Gender = Gender;
    }
    
    public String getCivilStatus(){
        return CivilStatus; 
    }
    
    public void setCivilStatus(String CivilStatus){
        this.CivilStatus = CivilStatus;
    }
    
    
}
