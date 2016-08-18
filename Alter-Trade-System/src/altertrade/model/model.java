package altertrade.model;

import altertrade.config.clsConnections;
import java.sql.Connection;

public class model extends clsConnections {

    protected Connection conn;
    protected String sql;

    protected void db_connect() {
        try {
            conn = super.setConnection(conn, "root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected String SupplierDetails() {
        return "SELECT \n"
                + "growers_record.growers_record_id AS 'pID',\n"
                + "growers_record.name,\n"
                + "growers_record.street,\n"
                + "growers_record.barangay,\n"
                + "`city`.city,\n"
                + "color_code.color_code,\n"
                + "contaiment.risk_containment,\n"
                + "price.price_description,\n"
                + "price.price_value,\n"
                + "DATE_FORMAT(growers_record.date_created,'%m-%d-%Y') AS 'date_created',\n"
                + "`status`.description AS 'status' FROM growers_record\n"
                + "\n"
                + "LEFT JOIN city ON city.city_id = growers_record.city_id\n"
                + "LEFT JOIN color_code ON color_code.color_code_id = growers_record.color_code_id\n"
                + "LEFT JOIN contaiment ON contaiment.containment_id = growers_record.contaiment_id\n"
                + "LEFT JOIN price ON price.price_id = growers_record.price_id\n"
                + "LEFT JOIN `status` ON `status`.status_id = growers_record.status_id";
    }

    protected String SupplierDetails(Object id) {
        return "SELECT \n"
                + "growers_record.growers_record_id AS 'pID',\n"
                + "growers_record.name,\n"
                + "growers_record.street,\n"
                + "growers_record.barangay,\n"
                + "`city`.city,\n"
                + "color_code.color_code,\n"
                + "contaiment.risk_containment,\n"
                + "price.price_description,\n"
                + "price.price_value,\n"
                + "DATE_FORMAT(growers_record.date_created,'%m-%d-%Y') AS 'date_created', \n"
                + "`status`.description AS 'status' FROM growers_record\n"
                + "\n"
                + "LEFT JOIN city ON city.city_id = growers_record.city_id\n"
                + "LEFT JOIN color_code ON color_code.color_code_id = growers_record.color_code_id\n"
                + "LEFT JOIN contaiment ON contaiment.containment_id = growers_record.contaiment_id\n"
                + "LEFT JOIN price ON price.price_id = growers_record.price_id\n"
                + "LEFT JOIN `status` ON `status`.status_id = growers_record.status_id\n"
                + "WHERE growers_record.growers_record_id='" + id + "'";
    }

    protected String workerDetails() {

        return "SELECT\n"
                + "worker.worker_id,\n"
                + "worker.firstname,\n"
                + "worker.middlename,\n"
                + "worker.lastname,\n"
                + "gender.description AS 'gender',\n"
                + "worker.age,\n"
                + "worker.elementary,\n"
                + "worker.highschool,\n"
                + "worker.college,\n"
                + "worker.undergraduate,\n"
                + "worker.vocational,\n"
                + "worker.skills,\n"
                + "worker.street,\n"
                + "worker.barangay,\n"
                + "city.city,\n"
                + "worker.contact_number,\n"
                + "worker.email_address,\n"
                + "position.position,\n"
                + "DATE_FORMAT(worker.start_date,'%m-%d-%Y') AS 'start_date',\n"
                + "DATE_FORMAT(worker.end_date,'%m-%d-%Y') AS 'end_date',\n"
                + "`status`.description AS 'status'\n"
                + "\n"
                + "FROM worker\n"
                + "\n"
                + "LEFT JOIN gender ON worker.gender_id = gender.gender_id\n"
                + "LEFT JOIN city ON worker.city_id = city.city_id\n"
                + "LEFT JOIN position ON worker.position_id = position.position_id\n"
                + "LEFT JOIN  `status` ON worker.status_id = `status`.status_id  ";

    }

    protected String workerDetails(Object id) {

        return "SELECT\n"
                + "worker.worker_id,\n"
                + "worker.firstname,\n"
                + "worker.middlename,\n"
                + "worker.lastname,\n"
                + "gender.description AS 'gender',\n"
                + "worker.age,\n"
                + "worker.elementary,\n"
                + "worker.highschool,\n"
                + "worker.college,\n"
                + "worker.undergraduate,\n"
                + "worker.vocational,\n"
                + "worker.skills,\n"
                + "worker.street,\n"
                + "worker.barangay,\n"
                + "city.city,\n"
                + "worker.contact_number,\n"
                + "worker.email_address,\n"
                + "position.position,\n"
                + "DATE_FORMAT(worker.start_date,'%m-%d-%Y') AS 'start_date',\n"
                + "DATE_FORMAT(worker.end_date,'%m-%d-%Y') AS 'end_date',\n"
                + "`status`.description AS 'status'\n"
                + "\n"
                + "FROM worker\n"
                + "\n"
                + "LEFT JOIN gender ON worker.gender_id = gender.gender_id\n"
                + "LEFT JOIN city ON worker.city_id = city.city_id\n"
                + "LEFT JOIN position ON worker.position_id = position.position_id\n"
                + "LEFT JOIN  `status` ON worker.status_id = `status`.status_id \n "
                + "WHERE worker.worker_id='" + id + "'";

    }

    protected String genderCombo() {
        return "SELECT * FROM `gender`";
    }
    
    protected String getGenderID(Object gender){
        return "SELECT * FROM `gender` WHERE description = '"+gender+"'";
    }

    protected String cityCombo() {
        return " SELECT * FROM `city` ";
    }

    protected String cityID(Object city) {
        return " SELECT city_id FROM `city` WHERE `city` = '" + city + "'";
    }

    protected String province() {
        return "SELECT * FROM `province` ";
    }
    
    protected String position() {
        return "SELECT * FROM `position` ";
    }
     protected String positionID(Object position) {
        return "SELECT * FROM `position` WHERE position = '"+position+"'";
    }

    public String insertWorker(
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
            String status
    ) {
        return "INSERT INTO `worker`(`firstname`, `middlename`, `lastname`, `gender_id`, `age`, `elementary`, `highschool`, `college`, `undergraduate`, `vocational`, `skills`, `street`, `barangay`, `city_id`, `contact_number`, `email_address`, `position_id`, `start_date`, `end_date`, `status_id`)\n "
                + "VALUES ('"+firstname+"','"+middlename+"','"+lastname+"','"+gender+"','"+age+"','"+elementary+"','"+highschool+"','"+college+"','"+undergraduate+"','"+vocational+"','"+skills+"','"+street+"','"+barangay+"','"+city+"','"+contact_number+"','"+email_address+"','"+position+"','"+start_date+"','9999-12-31','"+status+"')";
    }

}
