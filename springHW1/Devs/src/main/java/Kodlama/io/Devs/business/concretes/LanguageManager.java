package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		return languageRepository.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage language) throws Exception {
		if(language.getName().isEmpty()) {
			throw new Exception("Programlama dili boş olamaz");
		}
		for(ProgrammingLanguage lang : getAll())
		{
			if(lang.getName() == language.getName())
			{
				throw new Exception("Programlama dili tekrar edemez");
			}
		}
		languageRepository.add(language);
	}

	@Override
	public void delete(int id) throws Exception {
		for(ProgrammingLanguage lang : getAll()) {
			if(lang.getId() == id)
			{
				languageRepository.delete(id);
			}
		}
		throw new Exception("ID bulunamadı");
	}

	@Override
	public void update(ProgrammingLanguage language, int id) throws Exception {
		if(languageRepository.getById(id) == null)
		{
			throw new Exception("Ptogramlama dili bulunamadı");
		}
		languageRepository.update(language, id);
	}

}
