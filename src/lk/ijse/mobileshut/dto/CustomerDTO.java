package lk.ijse.mobileshut.dto;

public class CustomerDTO {

    private String id;
    private String fname;
    private String lname;
    private String address;
    private int tp;
    private String nic;
    private String date;


    public CustomerDTO() {

    }

    public CustomerDTO(String id, String fname,String lname, String address, int tp,String nic,String date) {
        this.id = id;
        this.fname = fname;
        this.lname=lname;
        this.address = address;
        this.tp=tp;
        this.nic=nic;
        this.date = date;
    }
    public CustomerDTO(String id){
        this.id=id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
