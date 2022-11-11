package Model;

/**
  Represents the Class used to store the ID of app administrators.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public class Admin implements User{
    /**
     * ID of this administrator.
     */
    private String adminId;
    
    /**
     * Method to set or modify the ID for this Admin object.
     * @param id This is the ID of this administrator.
     */
    public void setId(String id){
        adminId = id;
    }
    
    /**
     * Method to access ID of this administrator.
     * @return ID of this administrator.
     */
    public String getId(){
        return adminId;
    }
}
