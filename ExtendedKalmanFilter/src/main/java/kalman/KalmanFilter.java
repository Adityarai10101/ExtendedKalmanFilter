package kalman;
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


    public KalmanFilter() {

    }

    public void setMaximalTimeStep() {

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
    public void update() {

    }

    /* Just the prediction phase of update. */
    public void predict() {

    }

    // unfortunately there is no observable improvement
    public void predict_rk2() {

    }

    // this requires a lot of iterations (step size 0.001)
    public void predict_continuous() {
    }

    // this requires a lot of iterations (step size 0.001)
    public void predict_continuous_rk2() {

    }

    /* Just the estimation phase of update. */
    void estimate() {

    }
}