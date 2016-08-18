package altertrade.model;

public class Worker {

    private Integer worker_id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String gender;
    private Integer age;
    private String elementary;
    private String highschool;
    private String college;
    private String undergraduate;
    private String vocational;
    private String skills;
    private String street;
    private String barangay;
    private String city;
    private String contact_number;
    private String email_address;
    private String position;
    private String start_date;
    private String end_date;
    private String status;

    public Worker(
            String worker_id,
            String firstname,
            String middlename,
            String lastname,
            String gender,
            String age,
            String elementary,
            String highschool,
            String college,
            String undergraduate,
            String vocational,
            String skills,
            String street,
            String barangay,
            String city,
            String contact_number,
            String email_address,
            String position,
            String start_date,
          // String end_date,
            String status
    ) {
        this.worker_id = Integer.parseInt(worker_id);
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.gender = gender;
        this.age = Integer.parseInt(age);
        this.elementary = elementary;
        this.highschool = highschool;
        this.college = college;
        this.undergraduate = undergraduate;
        this.vocational = vocational;
        this.skills = skills;
        this.street = street;
        this.barangay = barangay;
        this.city = city;
        this.contact_number = contact_number;
        this.email_address = email_address;
        this.position = position;
        this.start_date = start_date;
      //  this.end_date = end_date;
        this.status = status;
    }

    //--------------------------
    // M U T A T O R S
    //--------------------------
    public void setWorderID(Integer workerID) {
        this.worker_id = workerID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setElementary(String elementary) {
        this.elementary = elementary;
    }

    public void setHighschool(String highschool) {
        this.highschool = highschool;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setUndergraduate(String undergraduate) {
        this.undergraduate = undergraduate;
    }

    public void setVocational(String vocational) {
        this.vocational = vocational;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setContactNumber(String contact_number) {
        this.contact_number = contact_number;
    }

    public void setEmailAddress(String email_address) {
        this.email_address = email_address;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStartDate(String start_date) {
        this.start_date = start_date;
    }

    public void setEndDate(String end_date) {
        this.end_date = end_date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //---------------------------
    // A C C E S S O R S
    //---------------------------
    public Integer getWorkerID() {
        return this.worker_id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getMiddlename() {
        return this.middlename;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getGender() {
        return this.gender;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getElementary() {
        return elementary;
    }

    public String getHighschool() {
        return this.highschool;
    }

    public String getCollege() {
        return this.college;
    }

    public String getUndergraduate() {
        return this.undergraduate;
    }

    public String getVocational() {
        return this.vocational;
    }

    public String getSkills() {
        return this.skills;
    }

    public String getStreet() {
        return this.street;
    }

    public String getBarangay() {
        return this.barangay;
    }

    public String getCity() {
        return this.city;
    }

    public String getContactNumber() {
        return this.contact_number;
    }

    public String getEmailAddress() {
        return this.email_address;
    }

    public String getPosition() {
        return this.position;
    }

    public String getStartDate() {
        return this.start_date;
    }

    public String getEndDate() {
        return this.end_date;
    }

    public String getStatus() {
        return this.status;
    }
    public String getName(){
        return  this.firstname+" "+middlename+". "+this.lastname;
    }
}
