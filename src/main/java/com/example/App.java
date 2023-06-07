package com.example;

import io.sentry.Sentry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String... args)
    {

        Sentry.init(options -> {
            options.setDsn("YOUR_DSN");
          
            // Set traces_sample_rate to 1.0 to capture 100%
            // of transactions for performance monitoring.
            // We recommend adjusting this value in production.
            options.setTracesSampleRate(1.0);
            options.setEnvironment("blobb");
          });

          try {
            throw new Exception("This is a test.");
          } catch (Exception e) {
            Sentry.captureException(e);
          }
        
        System.out.println( "Hello World!" );
    }
}
