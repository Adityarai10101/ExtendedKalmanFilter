
/* Refer to http://en.wikipedia.org/wiki/Kalman_filter for
 mathematical details. The naming scheme is that variables get names
 that make sense, and are commented with their analog in
 the Wikipedia mathematical notation.
 This Kalman filter implementation does not support controlled
 input.
 (Like knowing which way the steering wheel in a car is turned and
 using that to inform the model.)
 Vectors are handled as n-by-1 matrices.
 TODO: comment on the dimension of the matrices */

public class KalmanFilter {
    public double time = 0;
    public double maximalTimeStep = Double.MAX_VALUE;
    public ProcessModel model;

    public KalmanFilter()
    {
        model = new ProcessModel();
    }

    public KalmanFilter(ProcessModel model) {
    }

    public void setMaximalTimeStep(double maximalTimeStep) {
    }

    /*
     * Runs one timestep of prediction + estimation.
     *
     * Before each time step of running this, set f.observation to be the next
     * time step's observation.
     *
     * Before the first step, define the model by setting: f.state_transition
     * f.observation_model f.process_noise_covariance
     * f.observation_noise_covariance
     *
     * It is also advisable to initialize with reasonable guesses for
     * f.state_estimate f.estimate_covariance
     */
    public void update(double t, ObservationModel obs) {
\
 */
    }

    /* Just the prediction phase of update. */
    public void predict(doublt dt) {

    }

    // unfortunately there is no observable improvement
    public void predict_rk2(double dt) {

    }

    // this requires a lot of iterations (step size 0.001)
    public void predict_continuous(double dt) {
    }

    // this requires a lot of iterations (step size 0.001)
    public void predict_continuous_rk2(double dt) {

    }

    /* Just the estimation phase of update. */
    void estimate(ObservationModel obs) {

    }
}