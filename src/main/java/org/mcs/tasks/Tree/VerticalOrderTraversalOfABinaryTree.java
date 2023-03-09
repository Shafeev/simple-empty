package org.mcs.tasks.Tree;

import java.util.List;


/**
 * Учитывая корень двоичного дерева, вычислите вертикальный порядок обхода двоичного дерева.
 *
 * Для каждого узла в позиции (row, col), его левые и правые дочерние узлы будут находиться в позициях
 * (row + 1, col - 1) и (row + 1, col + 1) соответственно. Корень дерева находится в точке (0, 0).
 *
 * Вертикальный обход двоичного дерева представляет собой список упорядочений сверху вниз для каждого индекса столбца,
 * начиная с самого левого столбца и заканчивая самым правым столбцом. В одной строке и одном столбце может быть
 * несколько узлов. В таком случае отсортируйте эти узлы по их значениям.
 *
 * Возвращает обход бинарного дерева в вертикальном порядке.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Column -1: Only node 9 is in this column.
 * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
 * Column 1: Only node 20 is in this column.
 * Column 2: Only node 7 is in this column.
 */
public class VerticalOrderTraversalOfABinaryTree {

    public static void main(String[] args) {

    }

    private static List<List<Integer>> verticalTraversal(TreeNode root) {
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
