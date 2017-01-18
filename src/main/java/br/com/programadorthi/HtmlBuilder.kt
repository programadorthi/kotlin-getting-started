package br.com.programadorthi

/**
 * If you want to extends another class you have to use
 * 'open' keyword that makes inheritance possible
 */
open class Node {
    val contents = arrayListOf<Node>()
    fun tagName(): String {
        return javaClass.simpleName.toLowerCase()
    }
}

/**
 * Class created for inheritance that extends the Node class
 * <p/>
 * You have to initialize the constructor of inheritance class
 */
open class ContentNode : Node()

class Html : Node()
class Head : Node()
class Title : ContentNode()
class Body : Node()
class P : ContentNode()
class B : ContentNode()
class H1 : ContentNode()
class H2 : ContentNode()

/**
 * Classes with default constructor
 */
class A(var href: String) : ContentNode()
class Contents(var text: CharSequence) : ContentNode()

class DomSerializer {

    private fun applyContents(n: Node): String {
        return n.contents.map { toText(it) }.joinToString()
    }

    fun toText(n: Node): CharSequence {
        return when(n) {
            is Contents -> n.text
            is A -> """<a href="${n.href}">${applyContents(n)}</a>"""
            is ContentNode -> "<${n.tagName()}>${applyContents(n)}</${n.tagName()}>"
            else -> """
            <${n.tagName()}>
                ${applyContents(n)}
            </${n.tagName()}>
"""
        }
    }
}

class DomBuilder {

    fun head(it: Html, init: (Head) -> Unit) {
        addAndApply(it, Head(), init)
    }

    fun title(it: Head, init: (Title) -> Unit) {
        addAndApply(it, Title(), init)
    }

    fun body(it: Html, init: (Body) -> Unit) {
        addAndApply(it, Body(), init)
    }

    fun b(it: Node, init: (B) -> Unit) {
        addAndApply(it, B(), init)
    }

    fun p(it: Node, init: (P) -> Unit) {
        addAndApply(it, P(), init)
    }

    fun a(it: Node, href: String, init: (A) -> Unit) {
        addAndApply(it, A(href), init)
    }

    fun h1(it: Node, init: (H1) -> Unit) {
        addAndApply(it, H1(), init)
    }

    fun h2(it: Node, init: (H2) -> Unit) {
        addAndApply(it, H2(), init)
    }

    fun text(it: Node, contents: CharSequence) {
        val text = Contents(contents)
        it.contents += text
    }

    private fun <T : Node> addAndApply(parent: Node, t: T, init: (T) -> Unit) {
        parent.contents += t
        init(t)
    }
}

fun main(args: Array<String>) {
    val builder = DomBuilder()
    val html = Html()
    builder.head(html, {
        builder.title(it, {
            builder.text(it, "HTML with Kotlin")
        })
    })
    builder.body(html, {
        builder.h1(it, {
            builder.text(it, "HTML with Kotlin")
        })
        builder.p(it, {
            builder.text(it, "this format can be used as an alternative to templates")
        })
        builder.a(it, "https://kotlinlang.org/", {
            builder.text(it, "Kotlin")
        })
        builder.p(it, {
            builder.text(it, "This is some ")
            builder.b(it, {
                builder.text(it, "mixed")
            })
            builder.text(it, " text. For more see the ")
            builder.a(it, "https://kotlinlang.org/docs/reference/", {
                builder.text(it, "Kotlin docs")
            })
            builder.text(it, " reference")
        })
        builder.p(it, {
            builder.text(it, "More text.")
        })
    })
    println(DomSerializer().toText(html))
}