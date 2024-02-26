package youdev.sn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import youdev.sn.dto.RoleDto;
import youdev.sn.dto.UserDto;
import youdev.sn.services.RolesService;
import youdev.sn.services.UserService;

import java.util.stream.Stream;

@SpringBootApplication
public class AdminAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminAppApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RolesService rolesService, UserService userService){
		return args -> {
			Stream.of("Role_Tester","Role_Ing","Role_Control_Arch").forEach(nom->{
				RoleDto roleDto = new RoleDto();
				roleDto.setNom(nom);
				rolesService.createRoles(roleDto);

				UserDto userDto = new UserDto();
				userDto.setNom("Diarra");
				userDto.setPrenom("Youssou");
				userDto.setEmail("You@isi.sn");
				userDto.setPassword("1234");
				userDto.setEtat(1);
				userService.createUsers(userDto);


			});

		};
	}
}
