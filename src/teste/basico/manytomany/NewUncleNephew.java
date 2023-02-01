package teste.basico.manytomany;

import infrastructure.DAO;
import model.basic.manytomany.Nephew;
import model.basic.manytomany.Uncle;

public class NewUncleNephew {
	public static void main (String [] args) {
		
		Uncle uncle1 = new Uncle("Carlos");
		Uncle uncle2 = new Uncle("Andressa");
		Nephew nephew1 = new Nephew("Paola");		
		Nephew nephew2 = new Nephew("Bruno");
		
		
		uncle1.addNephew(nephew1);
		uncle1.addNephew(nephew2);
		
		uncle2.addNephew(nephew2);
		
		DAO<Object> uncleNephewDAO = new DAO<Object>();
		uncleNephewDAO.begin()
					  .add(uncle1)
					  .commit()
					  .closeDAO();
	}
}
