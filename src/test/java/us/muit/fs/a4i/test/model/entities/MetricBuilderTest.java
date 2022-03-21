/**
 * 
 */
package us.muit.fs.a4i.test.model.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import us.muit.fs.a4i.model.entities.Metric.MetricBuilder;

import us.muit.fs.a4i.exceptions.MetricException;
import us.muit.fs.a4i.model.entities.Metric;

/**
 * <p>
 * Test para probar el constructor de objetos Metric
 * </p>
 * 
 * @author Isabel Rom�n
 *
 */
class MetricBuilderTest {
	private static Logger log = Logger.getLogger(MetricBuilderTest.class.getName());

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test para el constructo Test method for
	 * {@link us.muit.fs.a4i.model.entities.Metric.MetricBuilder#MetricBuilder(java.lang.String, java.lang.Object)}.
	 */
	@Test
	void testMetricBuilder() {
		MetricBuilder underTest = null;
		try {
			underTest = new MetricBuilder<Integer>("watchers", 33);
		} catch (MetricException e) {
			fail("No deber�a haber saltado esta excepci�n");
			e.printStackTrace();
		}
		Metric newMetric = underTest.build();
		log.info("M�trica creada "+newMetric.toString());
		assertEquals("watchers", newMetric.getName(), "El nombre establecido no es correcto");
		assertEquals(33, newMetric.getValue(), "El valor establecido no es correcto");
		assertEquals(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).toString(),
				newMetric.getDate().toString(), "La fecha establecida no es correcta");
		assertEquals(newMetric.getDescription(), "Observadores, en la web aparece com forks","La descripci�n no coincide con la del fichero de configuraci�n");
		assertNull(newMetric.getSource(), "El origen no deber�a estar incluido");
		assertEquals(newMetric.getUnit(),"watchers", "No deber�a incluir las unidades");
		// A continuaci�n se prueba que se hace verificaci�n correcta del tipo de m�trica
		// Prueba un tipo que no se corresponde con el definido por la m�trica
		try {
			underTest = new MetricBuilder<String>("watchers", "hola");
			fail("Deber�a haber lanzado una excepci�n");
		} catch (MetricException e) {
			log.info("Lanza la excepci�n adecuada, MetricException");

		} catch (Exception e) {
			fail("La excepci�n capturada es " + e + " cuando se esperaba de tipo MetricException");
		}
		// Prueba una m�trica que no existe
		try {
			underTest = new MetricBuilder<String>("pepe", "hola");
			fail("Deber�a haber lanzado una excepci�n");
		} catch (MetricException e) {
			log.info("Lanza la excepci�n adecuada, MetricException");

		} catch (Exception e) {
			fail("La excepci�n capturada es " + e + " cuando se esperaba de tipo MetricException");
		}

	}

	/**
	 * Test method for
	 * {@link us.muit.fs.a4i.model.entities.Metric.MetricBuilder#description(java.lang.String)}.
	 */
	@Test
	void testDescription() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link us.muit.fs.a4i.model.entities.Metric.MetricBuilder#source(java.lang.String)}.
	 */
	@Test
	void testSource() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link us.muit.fs.a4i.model.entities.Metric.MetricBuilder#unit(java.lang.String)}.
	 */
	@Test
	void testUnit() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link us.muit.fs.a4i.model.entities.Metric.MetricBuilder#build()}.
	 */
	@Test
	void testBuild() {
		fail("Not yet implemented"); // TODO
	}

}
