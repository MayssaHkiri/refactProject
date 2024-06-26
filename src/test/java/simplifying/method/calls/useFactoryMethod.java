package simplifying.method.calls;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class useFactoryMethod {
  @Nested
  class notification_should {
    @Nested
    class throw_an_illegal_argument_exception {
      private void assertExceptionThrown(ThrowableAssert.ThrowingCallable throwingCallable) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(throwingCallable);
      }

      @Test
      void when_channel_is_null() {
        assertExceptionThrown(() -> new Notification(null));
      }

      @Test
      void when_channel_is_empty() {
        assertExceptionThrown(() -> new Notification(""));
      }

      @Test
      void when_channel_is_not_authorized() {
        assertExceptionThrown(() -> new Notification("Unauthorized"));
      }
    }

    @Nested
    class instantiate {
      private void assertNotificationNotNull(String channel) {
        Notification notification = new Notification(channel);
        assertThat(notification).isNotNull();
      }

      @Test
      void when_channel_is_SMS() {
        assertNotificationNotNull("SMS");
      }

      @Test
      void when_channel_is_EMAIL() {
        assertNotificationNotNull("EMAIL");

      }

      @Test
      void when_channel_is_PUSH() {
        assertNotificationNotNull("PUSH");
      }
    }
  }
}
