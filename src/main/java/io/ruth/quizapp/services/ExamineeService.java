package io.ruth.quizapp.services;

import io.ruth.quizapp.DTO.LoginDto;
import io.ruth.quizapp.Emf;
import io.ruth.quizapp.entities.Examinee;
import io.ruth.quizapp.exceptions.AuthenticationException;
import jakarta.annotation.ManagedBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;

@ManagedBean
public class ExamineeService implements IExamineeService{
    private EntityManager em;
    public ExamineeService() {
        EntityManagerFactory emf = Emf.getInstance().getFactory();
        this.em = emf.createEntityManager();
    }
    @Override
    public boolean editProfile(Examinee ex, int examineeId) {
        Examinee examinee = em.find(Examinee.class, examineeId);
        if(examinee != null){
            examinee.setName(ex.getName());
            examinee.setEmail(ex.getEmail());
            examinee.setPassword(ex.getPassword());
            em.persist(examinee);
            em.getTransaction().commit();
            return true;
        }else {
            return false;
        }
    }
    @Override
    public Examinee register(Examinee ex) {
        try {
            em.getTransaction().begin();
            em.persist(ex);
            em.getTransaction().commit();
            return ex;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error occurred while registering");
        }
    }

    @Override
    public Examinee getInformation(int examineeId) {
        Examinee ex = em.find(Examinee.class, examineeId);
        return ex;
    }

    public Examinee login(LoginDto ex) throws AuthenticationException {
        try {
            Examinee examinee = em.createQuery("SELECT e FROM Examinee e WHERE e.email = :email", Examinee.class)
                    .setParameter("email", ex.getEmail())
                    .getSingleResult();
            if (examinee != null) {
                if (examinee.getPassword().equals(ex.getPassword())) {
                    System.out.println("Login successful");
                    return examinee;
                } else {
                    throw new AuthenticationException("Invalid email or password");
                }
            }
            if(examinee == null){
                throw new AuthenticationException("Invalid email or password");
            }
            return examinee;
        } catch (NoResultException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new AuthenticationException("Error occurred while logging in");
        } catch(AuthenticationException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new AuthenticationException("Invalid email or password");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error occurred while logging in");
        }
    }
}
