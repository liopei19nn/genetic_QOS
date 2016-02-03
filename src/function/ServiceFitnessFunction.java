/**
 *
 */
package function;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

import model.WebService;
import model.WebServiceGroup;

/**
 * @author Li Pei
 *
 * Andrew ID : lip
 */
public class ServiceFitnessFunction extends FitnessFunction {

    private static final long serialVersionUID = 1L;

    private WebServiceGroup serviceGroup1;
    private WebServiceGroup serviceGroup2;
    private WebServiceGroup serviceGroup3;

    public ServiceFitnessFunction(WebServiceGroup serviceGroup1, WebServiceGroup serviceGroup2,
            WebServiceGroup serviceGroup3) {
        this.serviceGroup1 = serviceGroup1;
        this.serviceGroup2 = serviceGroup2;
        this.serviceGroup3 = serviceGroup3;
    }

    @Override
    protected double evaluate(IChromosome a_subject) {
        int sc1Num = getNumberOfServiceAtGene(a_subject, 0);
        int sc2Num = getNumberOfServiceAtGene(a_subject, 1);
        int sc3Num = getNumberOfServiceAtGene(a_subject, 2);

        WebService s1 = serviceGroup1.getServiceGroup().get(sc1Num);
        WebService s2 = serviceGroup2.getServiceGroup().get(sc2Num);
        WebService s3 = serviceGroup3.getServiceGroup().get(sc3Num);

        // double cost = s1.getCost() + s2.getCost() + s3.getCost();

        double cost = Math.min(s1.getCost() + s2.getCost() + s3.getCost(), s1.getCost() + s3.getCost());


        double reliability = Math.max(s1.getReliability() * s2.getReliability() * s3.getReliability(),
                s1.getReliability() * s3.getReliability());

        double time = Math.min(s1.getTime() + s2.getTime() + s3.getTime(), s1.getTime() + s3.getTime());


        double availability = Math.max(s1.getAvailability() * s2.getAvailability() * s3.getAvailability(),
                s1.getAvailability() * s3.getAvailability());

        return 1 + (-0.35 * cost + 0.15 * reliability - 0.3 * time + 0.2 * availability);

    }

    public static int getNumberOfServiceAtGene(IChromosome a_potentialSolution, int a_position) {
        Integer numCoins = (Integer) a_potentialSolution.getGene(a_position).getAllele();
        return numCoins.intValue();
    }

}
