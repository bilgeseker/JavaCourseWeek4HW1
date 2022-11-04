package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface LanguageService {
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id) throws Exception;
	void add(ProgrammingLanguage language)  throws Exception;
	void delete(int id) throws Exception;
	void update(ProgrammingLanguage language, int id) throws Exception;
}
