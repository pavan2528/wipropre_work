package employee;

public class EmployeeDAO {
	 private Connection conn;
	    
	    public EmployeeDAO() {
	        try {
	            // Register JDBC driver
	            Class.forName("com.mysql.jdbc.Driver");
	            // Open a connection
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "password");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public List<Employee> getAllEmployees() {
	        List<Employee> employees = new ArrayList<>();
	        try {
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Employee emp = new Employee();
	                emp.setId(rs.getInt("id"));
	                emp.setName(rs.getString("name"));
	                emp.setDesignation(rs.getString("designation"));
	                emp.setEmail(rs.getString("email"));
	                emp.setPhoneNumber(rs.getString("phone_number"));
	                emp.setAddress(rs.getString("address"));
	                emp.setSalary(rs.getDouble("salary"));
	                employees.add(emp);
	            }
	            rs.close();
	            ps.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return employees;
	    }
	    
	    public void addEmployee(Employee emp) {
	        try {
	            PreparedStatement ps = conn.prepareStatement(
	                    "INSERT INTO employee (name, designation, email, phone_number, address, salary) VALUES (?, ?, ?, ?, ?, ?)");
	            ps.setString(1, emp.getName());
	            ps.setString(2, emp.getDesignation());
	            ps.setString(3, emp.getEmail());
	            ps.setString(4, emp.getPhoneNumber());
	            ps.setString(5, emp.getAddress());
	            ps.setDouble(6, emp.getSalary());
	            ps.executeUpdate();
	            ps.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public Employee getEmployeeById(int id) {
	        Employee emp = null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee WHERE id=?");
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                emp = new Employee();
	                emp.setId(rs.getInt("id"));
	                emp.setName(rs.getString("name"));
	                emp.setDesignation(rs.getString("designation"));
	                emp.setEmail(rs.getString("email"));
	                emp.setPhoneNumber(rs.getString("phone_number"));
	                emp.setAddress(rs.getString("address"));
	                emp.setSalary(rs.getDouble("salary"));
	            }
	            rs.close();
	            ps.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return emp;
	    }
	    
	    public void updateEmployee(Employee emp) {
	        try {
	            PreparedStatement ps = conn.prepareStatement(
	                    "UPDATE employee SET name=?, designation=?, email=?, phone_number=?, address=?, salary=? WHERE id=?");
	            ps.setString(1, emp.getName());
	            ps.setString(2, emp.getDesignation());
	            ps.setString(3, emp.getEmail());
	            ps.setString(4, emp.getPhoneNumber());
	            ps.setString(5, emp.getAddress());
	            ps.setDouble(6, emp.getSalary());
	            ps.setInt(7, emp.getId());
	            ps.executeUpdate();
	            ps.close();
	        } catch (Exception
	}

	public void deleteEmployee(int id) {
	    try {
	        PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE id=?");
	        ps.setInt(1, id);
	        ps.executeUpdate();
	        ps.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
