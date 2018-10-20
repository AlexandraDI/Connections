package dao;

import dao.definitions.SettingDAO;
import dao.definitions.UserDAO;
import dao.definitions.UserHasSettingDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.UserHasSetting;
import model.Setting;
import model.User;
import model.UserHasSettingPK;

public class UserHasSettingDAOImpl extends DaoEM implements UserHasSettingDAO {

    @Override
    public List<UserHasSetting> findUserSettings(Integer userId) {
        UserDAOImpl dao = new UserDAOImpl();
        User find = dao.find(userId);
        if (find == null) {
            return null;
        } else {
            return find.getUserHasSettingList();
        }
    }

    @Override
    public List<User> findSettingUsers(Integer settingId) {
        SettingDAOImpl dao = new SettingDAOImpl();
        Setting find = dao.find(settingId);
        if (find == null) {
            return null;
        } else {
            return null;//find.;
        }

    }

    @Override
    public void create(Integer userId, Integer settingId, String value) {

        EntityTransaction transaction = em.getTransaction();

        User whichuser = em.find(User.class, userId);
        Setting whichsetting = em.find(Setting.class, settingId);

        if (whichuser != null && whichsetting != null) {

            transaction.begin();
            UserHasSetting entity = new UserHasSetting();
            UserHasSettingPK pk = new UserHasSettingPK();
            pk.setUserId(whichuser.getUserId());
            pk.setSettingId(whichsetting.getSettingId());

            entity.setUser(whichuser);
            entity.setSetting(whichsetting);
            entity.setValue(value);
            entity.setUserHasSettingPK(pk);
            em.persist(entity);

            transaction.commit();

        }

    }

    @Override
    public void update(Integer userId, Integer settingId, UserHasSetting changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        User whichuser = em.find(User.class, userId);
        Setting whichsetting = em.find(Setting.class, settingId);
        UserHasSetting uhs = new UserHasSetting();

        if (whichuser != null && whichsetting != null) {
            if (changes.getValue() != null) {
                //managed.setValue(changes.getValue());
                uhs.setUser(whichuser);
                uhs.setSetting(whichsetting);
                uhs.setValue(changes.getValue());
                em.persist(uhs);
                //whichuser.setValue(changes.getValue());
                //whichsetting.setValue(changes.getValue());
            }

        }

        transaction.commit();
    }

    public void update(UserHasSetting changes) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(changes);
        transaction.commit();
    }

    @Override
    public boolean remove(Integer userId, Integer settingId) {
        // problem

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        User whichuser = em.find(User.class, userId);
        Setting whichsetting = em.find(Setting.class, settingId);

        if (whichuser != null && whichsetting != null) {
            whichuser.getUserHasSettingList().remove(whichsetting);
            whichsetting.getUserHasSettingList().remove(whichuser);
            transaction.commit();
            return true;
        } else {
            transaction.commit();
            return false;
        }

    }

}
