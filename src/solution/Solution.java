/**
 *
 */
package solution;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

import function.ServiceFitnessFunction;
import model.WebService;
import model.WebServiceGroup;

/**
 * @author Li Pei
 *
 * Andrew ID : lip
 */
public class Solution {

    private WebServiceGroup serviceGroup1;
    private WebServiceGroup serviceGroup2;
    private WebServiceGroup serviceGroup3;

    public Solution() {

        serviceGroup1 = new WebServiceGroup();
        serviceGroup1.getServiceGroup().add(new WebService("S11", 20, 0.95, 2, 0.95));
        serviceGroup1.getServiceGroup().add(new WebService("S12", 30, 0.99, 3, 0.89));
        serviceGroup1.getServiceGroup().add(new WebService("S13", 23, 0.98, 23, 0.98));
        serviceGroup1.getServiceGroup().add(new WebService("S14", 12, 0.99, 1, 0.02));
        serviceGroup1.getServiceGroup().add(new WebService("S15", 25, 0.89, 3, 0.78));

        serviceGroup2 = new WebServiceGroup();
        serviceGroup2.getServiceGroup().add(new WebService("S21", 12, 0.70, 3, 0.70));
        serviceGroup2.getServiceGroup().add(new WebService("S22", 15, 0.99, 5, 0.93));
        serviceGroup2.getServiceGroup().add(new WebService("S23", 53, 0.96, 8, 0.96));

        serviceGroup3 = new WebServiceGroup();
        serviceGroup3.getServiceGroup().add(new WebService("S31", 11, 0.97, 9, 0.97));
        serviceGroup3.getServiceGroup().add(new WebService("S32", 12, 0.89, 12, 0.89));
        serviceGroup3.getServiceGroup().add(new WebService("S33", 12, 0.90, 1, 0.90));
        serviceGroup3.getServiceGroup().add(new WebService("S34", 15, 0.91, 3, 0.98));
        serviceGroup3.getServiceGroup().add(new WebService("S35", 18, 0.56, 6, 0.56));
        serviceGroup3.getServiceGroup().add(new WebService("S36", 23, 0.68, 2, 0.67));
        serviceGroup3.getServiceGroup().add(new WebService("S37", 22, 0.59, 1, 0.59));
        serviceGroup3.getServiceGroup().add(new WebService("S38", 21, 0.92, 2, 0.89));
    }

    public IChromosome getBestSolution() throws InvalidConfigurationException {


        FitnessFunction function = new ServiceFitnessFunction(serviceGroup1, serviceGroup2, serviceGroup3);
        Configuration configuration = new DefaultConfiguration();



        configuration.setFitnessFunction(function);



        Gene[] sampleGenes = new Gene[3];

        sampleGenes[0] = new IntegerGene(configuration, 0, serviceGroup1.getServiceGroup().size() - 1); // Quarters
        sampleGenes[1] = new IntegerGene(configuration, 0, serviceGroup2.getServiceGroup().size() - 1); // Dimes
        sampleGenes[2] = new IntegerGene(configuration, 0, serviceGroup3.getServiceGroup().size() - 1); // Nickels

        Chromosome sampleChromosome = new Chromosome(configuration, sampleGenes);

        configuration.setSampleChromosome(sampleChromosome);
        configuration.setPopulationSize(500);
        Genotype population = Genotype.randomInitialGenotype(configuration);

        for (int i = 0; i < 100; i++) {

            population.evolve();
        }

        return population.getFittestChromosome();

    }






    public static void main(String[] args) {
        Solution solution3 = new Solution();
        try {

            IChromosome bestSolution = solution3.getBestSolution();

            System.out.println("500 Population Size, 100 Generation of Evolution");
            System.out.println("Route of SC1 -> SC2 -> SC3");
            System.out.println("Fitness value : " + bestSolution.getFitnessValue());

            System.out.println("SC1 : " + solution3.serviceGroup1.getServiceGroup()
                    .get(ServiceFitnessFunction.getNumberOfServiceAtGene(bestSolution, 0)).getName());
            System.out.println("SC2 : " + solution3.serviceGroup2.getServiceGroup()
                    .get(ServiceFitnessFunction.getNumberOfServiceAtGene(bestSolution, 0)).getName());
            System.out.println("SC3 : " + solution3.serviceGroup3.getServiceGroup()
                    .get(ServiceFitnessFunction.getNumberOfServiceAtGene(bestSolution, 0)).getName());


        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
