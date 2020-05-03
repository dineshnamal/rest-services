package com.namal.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.namal.agency.model.Consultant;

@Component
public class ConsultantDaoService {
	private static List<Consultant> consultants = new ArrayList<Consultant>();
	static {
		consultants.add(new Consultant(1, "Namal", "1234", "namal3000@gmail.com", LocalDate.of(1977, 12, 28)));
		consultants.add(new Consultant(2, "Dinesh", "1234", "dincin@gmail.com", LocalDate.of(1982, 1, 2)));
		consultants.add(new Consultant(3, "Shanika", "1234", "shanikaw@gmail.com", LocalDate.of(1978, 2, 20)));
	}
	
	private static int userCount = consultants.size();

	public List<Consultant> findAll() {
		return consultants;
	}

	public Consultant save(Consultant consultant) {
		if(consultant.getId() == null) {
			consultant.setId(++userCount);
		}
		consultants.add(consultant);
		return consultant;
	}

	public Consultant findOne(Integer id) {
		for (Consultant consultant : consultants) {
			if (consultant.getId().equals(id)) { // check ==
				return consultant;
			}
		}
		return null;
	}

}
