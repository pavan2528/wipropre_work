package employee;

public class EmployeeController extends HttpServlet {
	
	    private static final long serialVersionUID = 1L;
	    private EmployeeDAO dao;
	    
	    public EmployeeController() {
	        super();
	        dao = new EmployeeDAO();
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getParameter("action");
	        if (action == null) {
	            action = "list";
	        }
	        switch (action) {
	        case "new":
	            showNewForm(request, response);
	            break;
	        case "insert":
	            insertEmployee(request, response);
	            break;
	        case "delete":
	            deleteEmployee(request, response);
	            break;
	        case "edit":
	            showEditForm(request, response);
	            break;
	        case "update":
	            updateEmployee(request, response);
	            break;
	        default:
	            listEmployee(request, response);
	            break;
	        }
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        List<Employee> employees = dao.getAllEmployees();
	        request.setAttribute("employees", employees);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
	        dispatcher.forward(request, response);
	    }
	    
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
	        dispatcher.forward(request, response);
	    }
	    
	    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Employee emp = new Employee();
	        emp.setName(request.getParameter("name"));
	        emp.setDesignation(request.getParameter("designation"));
	        emp.setEmail(request.getParameter("email"));
	        emp.setPhoneNumber(request.getParameter("phone_number"));
	        emp.setAddress(request.getParameter("address"));
	        emp.setSalary(Double.parseDouble(request.getParameter("salary")));
	        dao.addEmployee(emp);
	        response.sendRedirect("EmployeeController");
	    }
	    
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Employee emp = dao.getEmployeeById(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
	        request.setAttribute("employee", emp);
	        dispatcher.forward(request, response);
	    }
	    
	    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Employee emp = new Employee();
	        emp.setId(Integer.parseInt(request.getParameter("id")));
	        emp.setName(request.getParameter("name"));
	        emp.setDesignation(request.getParameter("designation"));
	        emp.setEmail(request.getParameter("email"));
	        emp.setPhoneNumber(request.getParameter("phone_number"));
	        emp.setAddress(request.getParameter("address"));
	        emp.setSalary(Double.parseDouble(request.getParameter("salary")));
	        dao.updateEmployee(emp);
	        response.sendRedirect("EmployeeController");
	    }
	    
	    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        dao.deleteEmployee(id);
	        response.sendRedirect("EmployeeController");
	    }
	}


