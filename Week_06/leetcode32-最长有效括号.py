class Solution:
    def longestValidParentheses(self, s: str) -> int:
        n = len(s)
        stack = []
        dp = [0] * (n + 1)
        for i, ch in enumerate(s):
            index = i + 1
            if ch == '(':
                stack.append(ch)
            else:
                if stack:
                    stack.pop()
                    pairs = dp[index - 1] + 1
                    pre_index = index - pairs * 2
                    if pre_index > 0:
                        pairs += dp[pre_index]
                    dp[index] = pairs
        return max(dp)*2
