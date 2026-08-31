<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>

            <head>

                <title>Mobile Phone Sales Summary</title>

                <style>

                    body {
                        font-family: Arial, sans-serif;
                        margin: 30px;
                    }

                    h1 {
                        text-align: center;
                    }

                    table {
                        width: 100%;
                        border-collapse: collapse;
                    }

                    th, td {
                        border: 1px solid black;
                        padding: 8px;
                        text-align: center;
                    }

                    th {
                        background-color: lightblue;
                    }

                    .highSales {
                        color: red;
                        font-weight: bold;
                    }

                </style>

            </head>

            <body>

                <h1>Mobile Phone Sales Summary</h1>

                <table>

                    <tr>
                        <th>Model Name</th>
                        <th>Model ID</th>
                        <th>Brand</th>
                        <th>Price</th>
                        <th>Color</th>
                        <th>SIM Size</th>
                        <th>Memory</th>
                        <th>Camera</th>
                        <th>Touch Screen</th>
                        <th>Number Sold</th>
                        <th>Store Name</th>
                    </tr>

                    <xsl:for-each select="MobileSalesReport/Mobile">

                        <tr>

                            <td>
                                <xsl:value-of select="ModelName"/>
                            </td>

                            <td>
                                <xsl:value-of select="ModelID"/>
                            </td>

                            <td>
                                <xsl:value-of select="Brand"/>
                            </td>

                            <td>
                                <xsl:value-of select="Price"/>
                            </td>

                            <td>
                                <xsl:value-of select="Color"/>
                            </td>

                            <td>
                                <xsl:value-of select="SIMSize"/>
                            </td>

                            <td>
                                <xsl:value-of select="Memory"/>
                            </td>

                            <td>
                                <xsl:value-of select="Camera"/>
                            </td>

                            <td>
                                <xsl:value-of select="TouchScreen"/>
                            </td>

                            <xsl:choose>

                                <xsl:when test="NoSold &gt; 10">
                                    <td class="highSales">
                                        <xsl:value-of select="NoSold"/>
                                    </td>
                                </xsl:when>

                                <xsl:otherwise>
                                    <td>
                                        <xsl:value-of select="NoSold"/>
                                    </td>
                                </xsl:otherwise>

                            </xsl:choose>

                            <td>
                                <xsl:value-of select="storeName"/>
                            </td>

                        </tr>

                    </xsl:for-each>

                </table>

            </body>

        </html>

    </xsl:template>

</xsl:stylesheet>