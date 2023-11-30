import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileLoaderTest {
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();
	ProjectList projectList = ProjectList.getInstance();
    ArrayList<Project> projects = projectList.getProjects();
	private Map<String, User> participantsMap = new HashMap<String, User>();
	//for generating a random uuid for users
	private UUID id1 = UUID.randomUUID();
	private UUID id2 = UUID.randomUUID();
	User James = new User(id1, "James", "Rogers", "Jrogers",
					"EK8g69Dk$G3", "jrogers@gmail.com", "803-730-4872");
	User Samantha = new User(id2, "Samantha", "Jacobs", "Sjacobs", 
                              "3wb3wN4^KD2", "sjacobs@gmail.com", "803-826-9943");
	
	@BeforeEach
	public void setup() {
		users.clear();
        users.add(James);
        users.add(new User(id2, "Samantha", "Jacobs", "Sjacobs", 
                              "3wb3wN4^KD2", "sjacobs@gmail.com", "803-826-9943"));
        DataWriter.saveUsers();
		participantsMap.put("Scrum Master", James);
		participantsMap.put("Developer", Samantha);
	}
	
	@AfterEach
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
    	DataWriter.saveUsers();
	}

    @Test
    void testGetUserListSize() {
        users = FileLoader.getUsers();
        assertEquals(2, users.size());
    }

	@Test
    void testGetProjectListSize() {
        projects = FileLoader.getProjects();
        assertEquals(1, projects.size());
    }

    @Test
	void testGetUsersSizeZero() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
		assertEquals(0, users.size());
	}

	@Test
	void testGetProjectsSizeZero() {
		ProjectList.getInstance().getProjects().clear();
		DataWriter.saveProjects();
		assertEquals(0, projects.size());
	}

    @Test
	void testGetFirstUserName() {
		users = FileLoader.getUsers();
		assertEquals("Jrogers", users.get(0).getUserName());
	}

	@Test
	void testGetFirstUserID() {
		users = FileLoader.getUsers();
		assertEquals(id1, users.get(0).getID());
	}

    @Test
	void testGetFirstUserFirstName() {
		users = FileLoader.getUsers();
		assertEquals("James", users.get(0).getFirstName());
	}

	@Test
	void testGetFirstUserEmail() {
		users = FileLoader.getUsers();
		assertEquals("jrogers@gmail.com", users.get(0).getEmail());
	}

	@Test
	void testGetFirstUserNumber() {
		users = FileLoader.getUsers();
		assertEquals("803-730-4872", users.get(0).getPhoneNum());
	}

	@Test
	void testGetSecondUserName() {
		users = FileLoader.getUsers();
		assertEquals("Sjacobs", users.get(1).getUserName());
	}

	@Test
	void testGetSecondUserID() {
		users = FileLoader.getUsers();
		assertEquals(id2, users.get(1).getID());
	}

    @Test
	void testGetSecondUserFirstName() {
		users = FileLoader.getUsers();
		assertEquals("Samantha", users.get(1).getFirstName());
	}

	@Test
	void testGetSecondUserEmail() {
		users = FileLoader.getUsers();
		assertEquals("sjacobs@gmail.com", users.get(1).getEmail());
	}

	@Test
	void testGetSecondUserNumber() {
		users = FileLoader.getUsers();
		assertEquals("803-826-9943", users.get(1).getPhoneNum());
	}

	@Test
	void testGetProjectName() {
		projects = FileLoader.getProjects();
		assertEquals("Chat Bot", projects.get(0).getTitle());
	}

	@Test
	void testGetProjectFirstColumnName() {
		projects = FileLoader.getProjects();
		assertEquals("Backlog", projects.get(0).getColumns().get(0).getColumnName());
	}

	@Test
	void testGetProjectParticipants() {
		projects = FileLoader.getProjects();
		assertEquals(participantsMap, projects.get(0).getParticipants());
	}

	@Test
	void testGetProjectComment() {
		projects = FileLoader.getProjects();
		assertEquals("Should the bot have some kind of unique personality?", projects.get(0).getComments().get(0).getComment());
	}


}