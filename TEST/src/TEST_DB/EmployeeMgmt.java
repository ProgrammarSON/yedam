package TEST_DB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeMgmt {
	EmployeeDAO dao = new EmployeeDAO();
	Scanner sc = new Scanner(System.in);
	
	public void empListProc() {
		SearchVO vo = new SearchVO();
		EmployeeDAO dao = new EmployeeDAO();
		
		vo.setSearchCondition("hire_date");
		vo.setSearchKeyword("19800101");
		List<EmployeeDTO> list = dao.getEmpList(vo);
		
		System.out.println("===============================================================================================");
		System.out.println("EMP_ID\t FIRST_NAME\t LAST_NAME\t EMAIL\t\t JOB_ID\t\t DATE");
		System.out.println("===============================================================================================");
		for(EmployeeDTO dto:list)
			System.out.println(dto);
	}
	
	public void empDTOProc() {
		System.out.println("��ȸ�� �����ȣ�� �Է��ϼ���.");
		String empNo = sc.nextLine();
		EmployeeDTO dto = dao.getEmpDTO(empNo);
		System.out.println(dto);
	}
	
	public void insertEmpProc() {
		System.out.println("�����ȣ�� �Է�ȭ����.");
		String empNo = sc.nextLine();
		System.out.println("�̸��� �Է��ϼ���.");
		String firstName = sc.nextLine();
		System.out.println("���� �Է��ϼ���.");
		String lastName = sc.nextLine();
		System.out.println("�̸����� �Է��ϼ���.");
		String email = sc.nextLine();
		System.out.println("������ �Է��ϼ���.");
		String job = sc.nextLine();
		
		EmployeeDTO dto =  new EmployeeDTO();
		dto.setEmployeeId(empNo);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(email);
		dto.setJobId(job);
		
		dao.insertEmp(dto);
	}
	
	public void updateEmpProc() {
		EmployeeDTO dto = new EmployeeDTO();
		System.out.println("������ �̸����� �Է��ϼ���.");
		String email = sc.nextLine();
		System.out.println("������ �����ȣ�� �Է�ȭ����.");
		String empNo = sc.nextLine();
		dto.setEmail(email);
		dto.setEmployeeId(empNo);
		dao.updateEmp(dto);
	}
	
	public void empListmap() {
		List<Map<String, Object>> list2 = new ArrayList<>();
		list2 = dao.getEmpListMap();
				
		for(Map<String, Object> map : list2)
			System.out.println(map);
	}
}
