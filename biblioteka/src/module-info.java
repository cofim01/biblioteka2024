/**
 * 
 */
/**
 * @author MRDAK-PC
 *
 */
module biblioteka {
	exports biblioteka.interfejs;
	exports biblioteka;

	
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	
	
	
	opens biblioteka.interfejs to org.junit.platform.commons;
}