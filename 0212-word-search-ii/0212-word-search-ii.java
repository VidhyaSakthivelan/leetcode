class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (node.child[index] == null)
                    node.child[index] = new TrieNode();

                node = node.child[index];
            }

            node.word = word;
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int i, int j,
                     TrieNode node, List<String> ans) {

        if (i < 0 || j < 0 || i >= board.length ||
            j >= board[0].length || board[i][j] == '#')
            return;

        char ch = board[i][j];
        node = node.child[ch - 'a'];

        if (node == null)
            return;

        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        dfs(board, i + 1, j, node, ans);
        dfs(board, i - 1, j, node, ans);
        dfs(board, i, j + 1, node, ans);
        dfs(board, i, j - 1, node, ans);

        board[i][j] = ch;
    }
}