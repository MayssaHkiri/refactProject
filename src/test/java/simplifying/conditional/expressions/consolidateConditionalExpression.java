package simplifying.conditional.expressions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class consolidateConditionalExpression {
  private static final String ACTION = "An Action";
  private final AuthorizationService authorizationService = new AuthorizationService();

  @Test
  void authorization_service_do_not_authorize_on_null_action() {
    assertThat(authorizationService.isAuthorized(null, null)).isFalse();
  }

  @Test
  void authorization_service_do_not_authorize_on_empty_action() {
    assertThat(authorizationService.isAuthorized(null, "")).isFalse();
  }

  @Test
  void authorization_service_do_not_authorize_disabled_user() {
    User disabledUser = User.builder().age(23).isDisabled(true).build();
    assertThat(authorizationService.isAuthorized(disabledUser, ACTION)).isFalse();
  }

  @Test
  void authorization_service_do_not_authorize_not_loyal_user() {
    User disabledUser = User.builder().age(23).build();
    assertThat(authorizationService.isAuthorized(disabledUser, ACTION)).isFalse();
  }

  @Test
  void authorization_service_authorize_loyal_major_enabled_user() {
    User authorizedUser = User.builder().age(23).isLoyal(true).build();
    assertThat(authorizationService.isAuthorized(authorizedUser, ACTION)).isTrue();
  }
}