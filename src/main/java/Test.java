import java.util.ArrayList;
import java.util.List;

import com.bilgeadam.entity.Address;
import com.bilgeadam.entity.PhoneNumber;
import com.bilgeadam.entity.User;
import com.bilgeadam.entity.UserInformation;
import com.bilgeadam.service.UserService;

public class Test {

	public static void main(String[] args) {

		UserService userService = new UserService();

		List<PhoneNumber> pList = new ArrayList<PhoneNumber>();
		PhoneNumber phoneNumber1 = new PhoneNumber("0555 000 5500");
		PhoneNumber phoneNumber2 = new PhoneNumber("0555 000 5577");
		pList.add(phoneNumber1);
		pList.add(phoneNumber2);

		List<Address> aList = new ArrayList<>();
		Address address = new Address("istanbul");
		aList.add(address);

		UserInformation userInformation = new UserInformation("Sezer", "Turkmen", "szr@gmail.com", pList, aList);
		User user = new User("SezerLT", "hello123", userInformation);

		userService.save(user);

	}

}
