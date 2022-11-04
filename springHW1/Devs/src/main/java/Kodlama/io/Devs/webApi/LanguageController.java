package Kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/{id}")
	public ProgrammingLanguage getById(@PathVariable() int id) throws Exception{
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage language) throws Exception{
		languageService.add(language);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody ProgrammingLanguage language, @PathVariable int id) throws Exception{
		languageService.update(language, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") int id) throws Exception{
		languageService.delete(id);
	}
}
