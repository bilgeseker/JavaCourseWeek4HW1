package Kodlama.io.Devs.dataAccess.abstracts;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import java.util.List;


public interface LanguageRepository {
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id) throws Exception;
	void add(ProgrammingLanguage language);
	void delete(int id) throws Exception;
	void update(ProgrammingLanguage language, int id) throws Exception;
}
