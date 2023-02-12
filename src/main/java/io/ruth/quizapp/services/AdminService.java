package io.ruth.quizapp.services;

import io.ruth.quizapp.DTO.LoginDto;
import io.ruth.quizapp.Emf;
import io.ruth.quizapp.entities.Admin;
import io.ruth.quizapp.exceptions.AuthenticationException;
import jakarta.annotation.ManagedBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
@ManagedBean
public class AdminService implements IAdminService {
    EntityManager em;
    public AdminService(){
        EntityManagerFactory emf = Emf.getInstance().getFactory();
        this.em = emf.createEntityManager();
    }
    public boolean editProfile(Admin admin, int adminId){
        Admin ad = em.find(Admin.class,adminId);
        ad.setName(admin.getName());
        ad.setUserId(admin.getUserId());
        ad.setEmail(admin.getEmail());
        ad.setCompany(admin.getCompany());
        ad.setPassword(admin.getPassword());

        em.getTransaction().begin();
        em.persist(ad);
        em.getTransaction().commit();
        return true;
    }
    public int registerAdmin(Admin admin) throws Exception {
        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();
        return admin.getUserId();
    }
    public Admin login(LoginDto loginDto){
        try {
            Admin admin = em.createQuery("SELECT e FROM Admin e WHERE e.email = :email", Admin.class)
                    .setParameter("email", loginDto.getEmail())
                    .getSingleResult();
            if (admin != null) {
                if (admin.getPassword().equals(loginDto.getPassword())) {
                    System.out.println("Login successful");
                    return admin;
                } else {
                    throw new AuthenticationException("Invalid email or password");
                }
            }
            if(admin == null){
                throw new AuthenticationException("Invalid email or password");
            }
            return admin;
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
