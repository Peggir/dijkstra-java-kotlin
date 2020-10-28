fun main() {
    val nodes = 6
    val edges: Array<IntArray> = Array(nodes) { IntArray(nodes) { -1 } }
    edges[0][1] = 34
    edges[0][3] = 43
    edges[1][2] = 56
    edges[1][3] = 20
    edges[1][4] = 57
    edges[2][5] = 20
    edges[3][1] = 20
    edges[3][4] = 50
    edges[4][2] = 37
    dijkstra(0, edges, nodes)
}

fun dijkstra(source: Int, edges: Array<IntArray>, nodes: Int) {
    // Initialize single source
    val d = IntArray(nodes) { Integer.MAX_VALUE }
    val pi = IntArray(nodes) { -1 }
    d[source] = 0

    val S: MutableList<Int> = ArrayList()
    val Q: MutableList<Int> = (0 until nodes).toMutableList()

    // Iterations
    while (Q.isNotEmpty()) {
        val u: Int = extractMin(Q, d)
        S.add(u)

        edges[u].forEachIndexed { v, vd ->
            if (vd != -1 && d[v] > d[u] + vd) {
                d[v] = d[u] + vd
                pi[v] = u
            }
        }
    }

    println("d: ${d.contentToString()}")
    println("pi: ${pi.contentToString()}")
}

fun extractMin(Q: MutableList<Int>, d: IntArray): Int {
    var minNode = Q[0]
    var minDistance: Int = d[0]

    Q.forEach {
        if (d[it] < minDistance) {
            minNode = it
            minDistance = d[it]
        }
    }

    Q.remove(minNode)
    return minNode
}