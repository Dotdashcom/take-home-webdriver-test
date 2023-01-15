package com.assignments.listeners;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Implements {@link org.testng.IAnnotationTransformer} to update annotations of testmethods at
 * runtime
 */
public class AnnotationTransformer implements IAnnotationTransformer {

  /**
   * Helps in setting retry analyser annotation to all the test methods at run time.
   */
  @Override
  public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,
      Method testMethod, Class<?> occurringClazz) {
    annotation.setRetryAnalyzer(RetryFailedTests.class);
  }

}
