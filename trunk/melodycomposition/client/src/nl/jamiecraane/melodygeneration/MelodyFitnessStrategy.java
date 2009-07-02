package nl.jamiecraane.melodygeneration;

import org.jgap.IChromosome;

import javax.swing.*;

import nl.jamiecraane.melodygeneration.Scale;

/**
 * Interface for all plugin strategies.
 * The setScale method is implemented on the abstract class implementing this interface. This is done because a lot of strategies need
 * information about the scale being used.
 *
 * @see AbstractMelodyFitnessStrategy
 */
public interface MelodyFitnessStrategy {
    /**
     * Calcluates the deviation for the given chromosome (melody) and the given implementation of this strategy.
     * @param chromosome The melody for which the fitness must be calculated
     * @return deviation between the given melody and the strategy
     */
    double calculateErrors(IChromosome chromosome);

    /**
     * @param scale the scale to set for this strategy.
     */
    void setScale(Scale scale);

    /**
     * Implementations should populate the passed in container for creating a UI with which the plugin can be configured.
     * @param container The container the plugin can use to create it's configuration UI.
     */
    void init(JPanel container);

    /**
     * Called once before calling the calculateErrors method during each iteration of the evolution.
     * The implementation can for example populate some private fields with the values from uicomponents
     * edited by the user.
     */
    void configure();
}
