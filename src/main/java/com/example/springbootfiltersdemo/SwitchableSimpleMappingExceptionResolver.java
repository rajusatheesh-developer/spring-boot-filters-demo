package com.example.springbootfiltersdemo;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

public class SwitchableSimpleMappingExceptionResolver extends
		SimpleMappingExceptionResolver {

	protected boolean enabled = true;

	public SwitchableSimpleMappingExceptionResolver(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Enabled or not?
	 * 
	 * @return Is enabled?
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Allow this resolver to be turned on and off whilst the application is
	 * running.
	 * 
	 * @param enabled
	 *            Set to enabled?
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Resolver only handles exceptions if enabled. Overrides method inherited
	 * from {@link AbstractHandlerExceptionResolver}
	 */
	@Override
	protected boolean shouldApplyTo(HttpServletRequest request, Object handler) {
		return enabled && super.shouldApplyTo(request, handler);
	}

}