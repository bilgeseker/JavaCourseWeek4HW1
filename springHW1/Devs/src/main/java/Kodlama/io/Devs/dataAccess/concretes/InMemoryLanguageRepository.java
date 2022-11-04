package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
@Repository
public class InMemoryLanguageRepository implements LanguageRepository{
	List<ProgrammingLanguage> languages;
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<ProgrammingLanguage>();
		languages.add(new ProgrammingLanguage(1,"C++"));
		languages.add(new ProgrammingLanguage(2,"C#"));
		languages.add(new ProgrammingLanguage(3,"Python"));
		languages.add(new ProgrammingLanguage(4,"Java"));
		languages.add(new ProgrammingLanguage(5,"Kotlin"));
		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languages;
	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		for(ProgrammingLanguage language : languages) {
			if(language.getId() == id) {
				return language;
			}
		}
		throw new Exception("Kayıt bulunamadı");
	}

	@Override
	public void add(ProgrammingLanguage language) {
		languages.add(language);
		System.out.println("eklendi");
	}

	@Override
	public void delete(int id) throws Exception {
		ProgrammingLanguage language = getById(id);
		languages.remove(language);
		System.out.println("çıkarıldı");
	}

	@Override
	public void update(ProgrammingLanguage language, int id) throws Exception{
		ProgrammingLanguage lang = getById(language.getId());
		lang.setName(language.getName());
		System.out.println("güncellendi");
	}

}
