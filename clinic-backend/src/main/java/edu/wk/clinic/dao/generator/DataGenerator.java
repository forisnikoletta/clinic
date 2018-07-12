package edu.wk.clinic.dao.generator;


import edu.wk.clinic.dao.DiseaseDAO;
import edu.wk.clinic.dao.SicknessDAO;
import edu.wk.clinic.dao.UserDAO;
import edu.wk.clinic.enums.USER_ROLES;
import edu.wk.clinic.model.Disease;
import edu.wk.clinic.model.Sickness;
import edu.wk.clinic.model.User;
import edu.wk.clinic.password.PasswordEncrypter;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Singleton
@Startup
public class DataGenerator {

    @EJB
    private UserDAO userDao;

    @EJB
    private DiseaseDAO diseaseDAO;

    @EJB
    private SicknessDAO sicknessDAO;

    @EJB
    private PasswordEncrypter passwordEncrypter;

    @PostConstruct
    public void initilize() {
        User adminUser = new User();
        adminUser.setAddress("AdminAddress");
        adminUser.setEmail("AdminEmail");
        adminUser.setFirst("AdminFirst");
        adminUser.setLast("AdminLast");
        adminUser.setPassword(passwordEncrypter.createHash("password"));
        adminUser.setPhone("AdminPhone");
        adminUser.setRole(USER_ROLES.ADMIN);
        userDao.create(adminUser);

        User normalUser = new User();
        normalUser.setAddress("UserAddress");
        normalUser.setEmail("UserMail");
        normalUser.setFirst("UserFirst");
        normalUser.setLast("UserLast");
        normalUser.setPassword(passwordEncrypter.createHash("password"));
        normalUser.setPhone("UserPhone");
        normalUser.setRole(USER_ROLES.USER);
        userDao.create(normalUser);


        Sickness sickness1 = new Sickness();
        sickness1.setTime(1);
        sickness1.setName("fejbetegseg");
        sicknessDAO.create(sickness1);

        Sickness sickness2 = new Sickness();
        sickness2.setTime(2);
        sickness2.setName("labbetegseg");
        sicknessDAO.create(sickness2);

        List<Sickness> sicknesses = sicknessDAO.findAll();
        Disease disease = new Disease();
            Set<Sickness> sicknessSet = new HashSet<>();
            Sickness sick = sicknesses.get(0);
            sicknessSet.add(sick);
            disease.setName("name");
            disease.setSicknesses(sicknessSet);
            diseaseDAO.create(disease);
        }

 }

