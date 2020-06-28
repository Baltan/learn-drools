package com.baltan.drools.filter;

import lombok.AllArgsConstructor;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

/**
 * Description:
 *
 * @author Baltan
 * @date 2020-06-28 14:44
 */
@AllArgsConstructor
public class RuleNameSuffixAgendaFilter implements AgendaFilter {
    private String ruleNameSuffix;

    /**
     * 规则名后缀为ruleNameSuffix的规则才会被执行
     *
     * @param match
     * @return
     */
    @Override
    public boolean accept(Match match) {
        String ruleName = match.getRule().getName();
        return ruleName.endsWith(ruleNameSuffix);
    }
}
