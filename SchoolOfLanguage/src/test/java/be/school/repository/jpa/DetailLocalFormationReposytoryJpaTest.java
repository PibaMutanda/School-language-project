package be.school.repository.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import be.school.enumClass.Jour;
import be.school.enumClass.Seance;
import be.school.model.DetailLocalFormation;
import be.school.model.Formateur;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.repository.DetailLocalFormationRepository;

/**
 * DetailLocalFormationReposytoryJpaTest class test
 * 
 * @author P. Mutanda
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DetailLocalFormationReposytoryJpaTest {

	@InjectMocks
	private DetailLocalFormationRepository detailLocalFormationRepository = new DetailLocalFormationReposytoryJpa();
	@Mock
	private EntityManager em;

	@Test
	public void testFindAllDistinct() {
		Query mockQuery = Mockito.mock(Query.class);
		DetailLocalFormation dLF1 = Mockito.mock(DetailLocalFormation.class);
		DetailLocalFormation dLF2 = Mockito.mock(DetailLocalFormation.class);
		List<DetailLocalFormation> list = new ArrayList<DetailLocalFormation>();
		list.add(dLF1);
		list.add(dLF2);
		Mockito.when(
				em.createQuery("select distinct df from DetailLocalFormation df"))
				.thenReturn(mockQuery);
		Mockito.when(mockQuery.getResultList()).thenReturn(list);
		List<DetailLocalFormation> resultList = detailLocalFormationRepository
				.findAllDistinct();
		Mockito.verify(em).createQuery(
				"select distinct df from DetailLocalFormation df");
		Mockito.verify(mockQuery).getResultList();
		assertEquals(dLF1, resultList.get(0));
		assertEquals(resultList.size(), list.size());
		assertTrue("La liste doit contenir l'objet dL2",
				resultList.contains(dLF2));

	}

	@Test
	public void testFindAllByFormateur() {
		Query mockQuery = Mockito.mock(Query.class);
		DetailLocalFormation dLF1 = Mockito.mock(DetailLocalFormation.class);
		DetailLocalFormation dLF2 = Mockito.mock(DetailLocalFormation.class);
		DetailLocalFormation dLF3 = Mockito.mock(DetailLocalFormation.class);
		List<DetailLocalFormation> list = new ArrayList<DetailLocalFormation>();
		list.add(dLF1);
		list.add(dLF2);
		list.add(dLF3);
		Formateur mockFormateur = Mockito.mock(Formateur.class);
		Mockito.when(list.get(0).getFormateur()).thenReturn(mockFormateur);
		Mockito.when(list.get(1).getFormateur()).thenReturn(mockFormateur);
		Mockito.when(list.get(2).getFormateur()).thenReturn(null);
		Mockito.when(mockFormateur.getNom()).thenReturn("MUTANDA");

		Mockito.when(
				em.createQuery("select dlf from DetailLocalFormation dlf where dlf.formateur=:formateur"))
				.thenReturn(mockQuery);
		Mockito.when(mockQuery.getResultList()).thenReturn(list);
		List<DetailLocalFormation> resultList = detailLocalFormationRepository
				.findAllByFormateur(mockFormateur);
		Mockito.verify(em)
				.createQuery(
						"select dlf from DetailLocalFormation dlf where dlf.formateur=:formateur");

		assertEquals("MUTANDA", resultList.get(0).getFormateur().getNom());
		assertEquals(dLF2, resultList.get(1));
		assertEquals(mockFormateur, resultList.get(1).getFormateur());
		assertEquals(null, resultList.get(2).getFormateur());

	}

	@Test
	public void testFindByLocalSession() {
		List<DetailLocalFormation> listDet = new ArrayList<DetailLocalFormation>();
		DetailLocalFormation mockDetailLocalFormation = Mockito
				.mock(DetailLocalFormation.class);
		listDet.add(mockDetailLocalFormation);
		Local mockLocal = Mockito.mock(Local.class);
		Query mockQuery = Mockito.mock(Query.class);
		Mockito.when(mockDetailLocalFormation.getLocal()).thenReturn(mockLocal);
		Mockito.when(mockLocal.getNumLocal()).thenReturn("455");

		Mockito.when(
				em.createQuery("select df from DetailLocalFormation df  where df.local= :local and  df.seance= :seance and df.jour= :jour"))
				.thenReturn(mockQuery);

		Mockito.when(mockDetailLocalFormation.getJour()).thenReturn(Jour.MARDI);
		Mockito.when(mockDetailLocalFormation.getSeance()).thenReturn(
				Seance.MATIN);
		Mockito.when(mockQuery.getResultList()).thenReturn(listDet);
		DetailLocalFormation result = detailLocalFormationRepository
				.findByLocalSession(mockLocal,
						mockDetailLocalFormation.getSeance(),
						mockDetailLocalFormation.getJour());
		assertEquals("455", result.getLocal().getNumLocal());
		assertEquals(mockLocal, result.getLocal());
		assertEquals(Jour.MARDI, result.getJour());
		assertEquals(Seance.MATIN, result.getSeance());
	}

	@Test
	public void testFindAllByFormation() {
		Query mockQuery = Mockito.mock(Query.class);
		Formation mockFormation = Mockito.mock(Formation.class);
		List<DetailLocalFormation> listeDetail = new ArrayList<DetailLocalFormation>();
		DetailLocalFormation detailLocalFormation1 = new DetailLocalFormation();
		DetailLocalFormation detailLocalFormation2 = new DetailLocalFormation();
		detailLocalFormation1.setNiveau("4");
		detailLocalFormation1.setJour(Jour.VENDREDI);
		detailLocalFormation2.setNiveau("1");
		detailLocalFormation2.setSeance(Seance.SOIR);
		listeDetail.add(detailLocalFormation1);
		listeDetail.add(detailLocalFormation2);
		Mockito.when(mockFormation.getDetailLocalFormations()).thenReturn(
				listeDetail);
		Mockito.when(
				em.createQuery("select dlf from DetailLocalFormation dlf where dlf.formation= :formation"))
				.thenReturn(mockQuery);
		Mockito.when(mockQuery.getResultList()).thenReturn(listeDetail);
		List<DetailLocalFormation> result = detailLocalFormationRepository
				.findAllByFormation(mockFormation);
		Mockito.verify(mockQuery).setParameter("formation", mockFormation);
		assertEquals(2, result.size());
		assertArrayEquals(listeDetail.toArray(), result.toArray());
		assertEquals("1", result.get(1).getNiveau());
		assertEquals(Jour.VENDREDI, result.get(0).getJour());
		assertEquals(Seance.SOIR, result.get(1).getSeance());
		assertEquals(detailLocalFormation1, result.get(0));
		assertEquals(detailLocalFormation2, result.get(1));
	}

	@Test
	public void testFindByLocalFormationNiveau() {
		Query mockQuery = Mockito.mock(Query.class);
		Local local = new Local();
		local.setCapacite("14");
		Formation formation = new Formation();
		formation.setTitre("English");
		DetailLocalFormation mockDetailLocalFormation = Mockito
				.mock(DetailLocalFormation.class);
		List<DetailLocalFormation> listDet = new ArrayList<DetailLocalFormation>();
		listDet.add(mockDetailLocalFormation);
		Mockito.when(mockDetailLocalFormation.getLocal()).thenReturn(local);
		Mockito.when(mockDetailLocalFormation.getFormation()).thenReturn(
				formation);
		Mockito.when(mockDetailLocalFormation.getNiveau()).thenReturn("7");
		Mockito.when(
				em.createQuery("select df from DetailLocalFormation df where df.local= :local and df.formation= :formation and df.niveau=:niveau"))
				.thenReturn(mockQuery);
		Mockito.when(mockQuery.getResultList()).thenReturn(listDet);
		DetailLocalFormation result = detailLocalFormationRepository
				.findByLocalFormationNiveau(local, formation, "English");
		assertEquals("14", result.getLocal().getCapacite());
		assertEquals("ENGLISH", result.getFormation().getTitre());
		assertEquals(result, listDet.get(0));
	}

	@Test
	public void testFindByLocalFormation() {
		Local local = new Local();
		local.setEstLibre(true);
		Formation formation = new Formation();
		formation.setCodeFormation("Fr");
		DetailLocalFormation mockDetailLocalFormation = Mockito
				.mock(DetailLocalFormation.class);
		Mockito.when(mockDetailLocalFormation.getLocal()).thenReturn(local);
		Mockito.when(mockDetailLocalFormation.getFormation()).thenReturn(
				formation);
		List<DetailLocalFormation> listDet = new ArrayList<DetailLocalFormation>();
		listDet.add(mockDetailLocalFormation);
		Query mockQuery = Mockito.mock(Query.class);
		Mockito.when(
				em.createQuery("select df from DetailLocalFormation df where df.local= :local and df.formation= :formation"))
				.thenReturn(mockQuery);
		Mockito.when(mockQuery.getResultList()).thenReturn(listDet);
		DetailLocalFormation result = detailLocalFormationRepository
				.findByLocalFormation(local, formation);
		assertEquals(result, listDet.get(0));
		assertEquals("Fr", result.getFormation().getCodeFormation());
		assertTrue(result.getLocal().isEstLibre());

	}
}
